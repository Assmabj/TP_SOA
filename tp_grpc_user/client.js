const grpc= require('grpc');
const protoLoader= require('@grpc/proto-loader');
const packageDef= protoLoader.loadSync("User.proto",{});
const grpcObject= grpc.loadPackageDefinition(packageDef);
const todoPackage =grpcObject.todoPackage;

const client = new todoPackage.User('localhost:9000',grpc.credentials.createInsecure());




client.deleteUser({
    'id' :2,
    'firstname' : 'Rania',
    'lastname'   :'Mahmoud'
},(err,response)=>{
    console.log('supprimer utilisateur' +JSON.stringify(response));
})

client.updateUser({
    'id' :1,
    'firstname' : 'Ayoub',
    'lastname'   : 'Beji'
},(err,response)=>{
    console.log('modification utilisateur' +JSON.stringify(response));
})


client.readUsers({},(err,response)=>{
    console.log('liste utilisateur' +JSON.stringify(response));
})


client.createUser({
    'id' :2,
    'firstname' : 'Rania',
    'lastname'   :'Mahmoud'
   },(err, response) =>{
   console.log('creation utilisateur avec succés' +JSON.stringify(response));
})

client.createUser({
    'id' :1,
    'firstname' : 'Asma',
    'lastname'   : 'Ben jemie'
   },(err, response) =>{
   console.log('creation utilisateur avec succés' +JSON.stringify(response));
})

