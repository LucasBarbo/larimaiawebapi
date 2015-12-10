'use strict';

appCrudAngular.controller('EstadoController', function($scope, $http){

    $scope.estados = {};//Lista de estados que estão vinculados a tela
    $scope.estado = {};//Objeto de estado vinculado a tela

    $scope.listar = function(){
        $http.get("ws/estado/lista").success(function(dados){
            $scope.estados = dados;
        });
    };

    //metodo salvar cliente
    $scope.salvar = function(){
        $http.post("ws/estado/salvar", $scope.cliente).success(function(dados){
            window.alert("salvo com sucesso");
            $scope.estado= {};
            $scope.listar();
        });

    };

    $scope.listar();

    $scope.excluir =  function (id){$http.delete("ws/estado/excluir/"+ id).success(function (){ $scope.listar(); });};


    $scope.editar = function(estado){

        $scope.estado = estado;

    }

});
