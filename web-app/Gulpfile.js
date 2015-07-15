var gulp = require('gulp');
var connect = require('gulp-connect');

// Servidor web de desarrollo
gulp.task('server', function() {
  connect.server({
    root: 'app',
    hostname: '0.0.0.0',
    port: 8087,
    livereload: true
  });
});

var stylus = require('gulp-stylus');
var nib = require('nib');

// Pre-procesa archivos Stylus a CSS y recarga los cambios
gulp.task('css', function() {
  gulp.src('./app/stylesheets/*.styl')
    .pipe(stylus({ use: nib() }))
    .pipe(gulp.dest('./app/stylesheets'))
    .pipe(connect.reload());
});

// Recarga el navegador cuando hay cambios en el HTML
gulp.task('html', function() {
  gulp.src('./app/**/*.html')
    .pipe(connect.reload());
});

var jshint  = require('gulp-jshint');
var stylish = require('jshint-stylish');

// Busca errores en el JS y nos los muestra por pantalla
gulp.task('jshint', function() {
  return gulp.src('./app/scripts/**/*.js')
    .pipe(jshint('.jshintrc'))
    .pipe(jshint.reporter('jshint-stylish'))
    .pipe(jshint.reporter('fail'));
});

// Busca en las carpetas de estilos y javascript los archivos que hayamos creado
// para inyectarlos en el index.html
var inject  = require('gulp-inject');
var wiredep = require('wiredep').stream;
var angularFilesort = require('gulp-angular-filesort');

gulp.task('inject', function() {
  return gulp.src('index.html', {cwd: './app'})
    .pipe(inject(
      gulp.src(['./app/scripts/**/*.js']).pipe(angularFilesort()), {
      read: false,
      ignorePath: '/app'
    }))
    .pipe(inject(
      gulp.src(['./app/stylesheets/**/*.css']), {
        read: false,
        ignorePath: '/app'
      }
    ))
    .pipe(gulp.dest('./app'));
});

// Inyecta las librerias que instalemos vía Bower
gulp.task('wiredep', function () {
  gulp.src('./app/index.html')
    .pipe(wiredep({
      directory: './app/lib'
    }))
    .pipe(gulp.dest('./app'));
});

var templateCache = require('gulp-angular-templatecache');
gulp.task('templates', function(){
  gulp.src('./app/views/**/*.html')
    .pipe(templateCache({
      root: 'views/',
      module: 'usm.templates',
      standalone: true
    }))
    .pipe(gulp.dest('./app/scripts'));
});

// Concatenación de ficheros css y js
var gulpif = require('gulp-if');
var minifyCss = require('gulp-minify-css');
var useref = require('gulp-useref');
var uglify = require('gulp-uglify');

gulp.task('compress', function(){
  gulp.src('./app/index.html')
    .pipe(useref.assets())
    .pipe(gulpif('*.js', uglify({mangle: false})))
    .pipe(gulpif('*.css', minifyCss()))
    .pipe(gulp.dest('./dist'));
});

// Copiamos el index.html apuntando a archivos minificados en dist
// Tambien se copian archivos de fuentes
gulp.task('copy', function(){
  gulp.src('./app/index.html')
    .pipe(useref())
    .pipe(gulp.dest('./dist'))
  gulp.src('./app/lib/fontawesome/fonts/**')
    .pipe(gulp.dest('./dist/fonts'));
});

gulp.task('build', ['templates', 'compress', 'copy']);

// Vigila cambios que se produzcan en el código
// y lanza las tareas relacionadas
gulp.task('watch', function() {
  gulp.watch(['./app/**/*.html'], ['html']);
  gulp.watch(['./app/stylesheets/**/*.styl'], ['css']);
  gulp.watch(['./app/scripts/**/*.js', './Gulpfile.js'], ['jshint']);
  gulp.watch(['./app/stylesheets/**/*.styl'], ['css', 'inject']);
  gulp.watch(['./app/scripts/**/*.js', './Gulpfile.js'], ['jshint', 'inject']);
  gulp.watch(['./bower.json'], ['wiredep']);
});

gulp.task('default', ['server', 'inject', 'wiredep', 'watch']);
