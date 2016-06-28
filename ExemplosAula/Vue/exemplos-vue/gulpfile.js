var gulp = require("gulp");
var babel = require("gulp-babel");
var rollup     = require('gulp-rollup');

gulp.task("js", function () {
  return gulp.src("src/app.js")
    .pipe(rollup())

	.pipe(babel())	   
  
    .pipe(gulp.dest("build"))
});
// configure which files to watch and what tasks to use on file changes
gulp.task('watch', function() {
  gulp.watch('src/*.js', ['js']);
});

gulp.task('default', ['watch']);