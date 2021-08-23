
/**
 * Creation of a basic function
 * 
 * @param $scope
 * @param $http
 * @returns
 */
function getTask1Function($scope, $http) {
    $http.get('http://localhost:8080/tasks/1').
       success(function(data) {
          $scope.task = data;
       });
}
/**
 *  ! IMPORTANT !
 * module('app';[])  ==> <html ng-app='app'>
 * 
 * 1/ Adding a controller getTaskController that lead to the function getTask1Function  
 * 
 * Otherwise you will have that error
 * angular.js:12330Error: [ng:areq] http://errors.angularjs.org/1.4.3/ng/areq?p0=getTask1Controller&p1=not%20a%20function%2C%20got%20undefined
 *    at Error (native)
 *    at 
 *     
 *  2/  link the Angular module 'ngResource' to my controller  
 */
angular.module('app', ['ngResource']).controller('getTask1Controller', getTask1Function);


/**
 * **** IDIOMS ****
 * 
 * Creating the module 'app'
 * >  angular.module('app', [])
 * 
 * Create the module 'app' giving it the resource 'app.controllers'   
 * >angular.module('app', ['app.controllers'])
 * WARNING : Once the module 'app' is created you cannot add a new resource, it will always create a new one. 
 * 
 * Creating the module 'app.controller' 
 * > angular.module('app.controllers', [])
 * WARNING : this 'app.controllers' is not automatically a sub module of 'app' (if you thought it could be related with the name
 */

/**
 * We create a factory to specifically construct the $resource 
 */
angular.module('app').factory('Task', function($resource) {
     return $resource('http://dedtappa02.ext.tdc:8080/next-todo-mkrok-api/tasks/:id', null, {
        'update' : {method: 'PUT'},
        'patch' : {method: 'PATCH'}
     } ); // Note the full endpoint address
});



/**
 * Creating  basic operations for task objects
 */
angular.module('app').controller('taskManagerController', function($scope, Task) {
    
    //// variables declarations  
    
    ////  functions declarations
    
    // viewtask is the name in the view > getTask is the name in the JS => the link is not automatic
    $scope.viewTask = getTask;
    $scope.editTask = editTask;
    $scope.createTask = createTask;
    $scope.deleteTask = deleteTask; 
    $scope.toogleTask = toogleTask; 
    var selectedIndex = null;

    // Init
    Task.get(null, function(data) {
        console.log(data);
        $scope.tasks = data._embedded.task; // The rest API does embbed results in the json path _embbeded.task
    }); //query() returns all the tasks

    
    // functions 
    function getTask (task, index){ 
      Task.get({ id: task.id }, function(task) {
         // console.log(task);
         $scope.selectedTask = task;
         selectedIndex = index;
      }); // get() returns a single task
    }
 

    //Perform "PUT http://mydomain.com/api/task/:id"
    function editTask(task) {
       Task.update({ id: task.id }, task, function(item){
           $scope.tasks[selectedIndex] = item;
           selectedIndex = null;
           $scope.selectedTask = null;
       });
    };
    
    //Perform "DELETE http://mydomain.com/api/task/:id"
    function deleteTask (task, index) {
        Task.delete(task).$promise.then(function(item){
            $scope.tasks.splice(index,1);
            newTask=null;
        });
    };

    //Perform "POST http://mydomain.com/api/task/:id"
    // better that var createTask = function(task) { <= no issue with scope
    function createTask (task) {
       Task.save(task).$promise.then(function(item){
           $scope.tasks.push(item);
       });
    };
  

    //Perform "PUT http://mydomain.com/api/task/:id"
    function toogleTask(task) {
    	// allows to 
       Task.patch({id:task.id}, {done:task.done });
    };

});

