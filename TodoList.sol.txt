pragma solidity ^0.5.1;

contract TodoList {
    uint public taskCount=0;
    
    struct Task{
        uint id;
        string content;
        bool completed;
        
    }
    mapping(uint=>Task) public tasks;
    
    //constructor
    
    event TaskCreated( uint id,string content, bool completed);
    
    event TaskCompleted(uint id, bool completed);
    
    //Fuctions to create TaskCompleted
    
    function createTask(string memory _content) public{
        taskCount++;
        tasks[taskCount]= Task(taskCount,_content,false);
        emit TaskCreated(taskCount,_content,false);
        
    }
    
    function toggleCompleted(uint _id ) public{
        Task memory _task = tasks[_id];
        _task.completed = !_task.completed;
        tasks[_id]= _task;
        emit TaskCompleted(_id,_task.completed);
    }
    function getTask(uint _id) public view returns(string memory){
        return(tasks[_id].content);
    }
}

