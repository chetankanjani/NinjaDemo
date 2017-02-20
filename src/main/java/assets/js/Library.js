var Library=angular.module('Library',[]);

Library.factory('Library',['$http',function($http){
	var Library={};
	Library.books=[];

	Library.addBook=function (book){
//		for(i in Library.books){
//			if(i == book){
//				return false;
//			}
//		}
//		Library.books.push(book);
		return $http.post('/newBook',book).success(function(data){
			
		});
		
	}
	Library.getAllBooks = function(){
		return $http.get('/viewAllBooks').success(function(data){
			Library.books=data;
		});
	}
	Library.removeBook=function(book){
		var _index = Library.books.indexOf(book);  
        Library.books.splice(_index, 1);  
	}
	return Library;
}]);