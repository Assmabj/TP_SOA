const grpc= require('grpc');
const protoLoader= require('@grpc/proto-loader');
const packageDef= protoLoader.loadSync("User.proto",{});
const grpcObject= grpc.loadPackageDefinition(packageDef);
const todoPackage =grpcObject.todoPackage;

const server = new grpc.Server();
server.bind('localhost:9000',grpc.ServerCredentials.createInsecure());
server.addService(todoPackage.User.service,{
    'createUser' : createUser,
    'readUsers'  : readUsers,
    'deleteUser' :deleteUser,
    'updateUser' : updateUser
});

server.start();

const users =[];

function createUser(call, callback)
{
    const UserItem={
        'id' : users.length+1,
        'firstname' : call.request.firstname,
        'lastname' : call.request.lastname
    }
    users.push(UserItem);
    callback(null,UserItem);
}


function deleteUser(call, callback)
{
    const UserItem={
        'id' : call.request.id,
        'firstname' : call.request.firstname,
        'lastname' : call.request.lastname
    }
    const index =users.findIndex(u => u.id == UserItem.id  & u.firstname==UserItem.firstname & u.lastname==UserItem.lastname );   
    console.log(index)
    users.splice(index,1);
    callback(null,{'items':users});
}
   

function updateUser(call, callback)
{
    
    
    const UserItem={
        'id' : call.request.id,
        'firstname' : call.request.firstname,
         'lastname' : call.request.lastname
        
    }
    const index =users.findIndex(u => u.id == UserItem.id);   

    users[index].firstname=UserItem.firstname;
    users[index].lastname=UserItem.lastname;
        callback(null,{'items':users});
}

 function readUsers
    (call, callback)
    {
        callback(null,{'items':users});

    }