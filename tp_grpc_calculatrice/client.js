const grpc= require('grpc');
const protoLoader= require('@grpc/proto-loader');
const packageDef= protoLoader.loadSync("calculatrice.proto",{});
const grpcObject= grpc.loadPackageDefinition(packageDef);
const todoPackage =grpcObject.todoPackage;

const client = new todoPackage.calculatrice('localhost:9000',grpc.credentials.createInsecure());

client.addition({
     'firstinput' :3,
     'secondinput' : 2
    },(err, response) =>{
    console.log('Resultat addition' +JSON.stringify(response));
})


client.multiplication({
    'firstinput' :4,
    'secondinput' : 2
   },(err, response) =>{
   console.log('Resultat multiplication ' +JSON.stringify(response));
})

client.division({
    'firstinput' :6,
    'secondinput' : 0
   },(err, response) =>{
   console.log('Resultat  division' +JSON.stringify(response));
})

client.soustraction({
    'firstinput' :1,
    'secondinput' : 2
   },(err, response) =>{
   console.log('Resultat soustraction ' +JSON.stringify(response));
})