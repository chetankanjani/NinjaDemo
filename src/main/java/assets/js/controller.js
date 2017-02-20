var controller= angular.module('controller', [
    ]);

controller.controller('controller',["$scope","$window",'Library','Book',function ($scope,$window,Library,Book) {
    
    //adding static data
    $scope.edit=false;
    $scope.id=-1;
    $scope.book={name:"",author:"",price:"",description:"",edit:false};
    $scope.books=[];
    
    $scope.DeleteData = function (book) { 
        Library.removeBook(book);
    } 

    $scope.addData = function (book) { 
        if(!book.name){
            $window.alert("Name cannot contain special characters");
        }
        if( !book.author || !book.price || !book.description){
            $window.alert("All details are required");
            return ;
        }
        for(i in $scope.books){
            if(i == book.name){
                $window.alert("Book already exists");
                return ;
            }
        }
        var b={name:book.name,author:book.author,price:book.price,description:book.description,category:book.category};
        Library.addBook(b)
        .then(function(data){
        	 Library.getAllBooks()
    	    .then(function(data){
    	        $scope.books=data.data;
    	    });
        });
       
        $scope.newbook={};
    } 
    $scope.editData = function(book){
        $scope.id = Library.books.indexOf(book);  
        book.edit=true;
        $scope.editbook=book;     
    }

    $scope.update = function(book){
        book.edit=false;
        // $scope.editbook={};
    }
    Library.getAllBooks()
    .then(function(data){
        $scope.books=data.data;
    });
  
}]);