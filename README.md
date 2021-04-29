# COSC_OP_SYS
Private Operating System Simulation

This is an academic project for bowie state university

This application is intended to simulate a simple operating system as follows:

Ten processes are stored in main memory at any given time. 
These processes will reference scripts written in a scripting langauge. We decided to use bash shell scripts for simplicity. 
Each process has its own PCB (Process Control Block) which contains the process id, the process page table, and the script.

A script associated to the process is split into pages of a configurable size( this size is defaulted to 64 bytes but can be configured by the user using command line arguments)

The pages for a script are stored in the PCB and each page content is stored in a frame of the same size which is stored in Main memory.

Once a process is split into pages and its frames are stored in memory, the process is placed into the Ready Queue to further processing by the CPU. 

Only 10 processes are allowed to be stored in main memory at a time, all remaining processes are not paginated at that time and are instead stored in the blocked ready queue until space is allocated for their scripts to be stored as frames in memory.

The CPU is in charge of executing the processes in the ready queue. 
To execute a process, the CPU will retrive the next process from the ready queue and retrive its next unprocessed page from the corresponding page table. 
The frame for this page is then retrived from main memory and the data in it is stored in a temp file to be executed by the CPU. 
If the process has further pages to be executed, it is placed back onto the ready queue and the CPU pulls the next process and continues the cycle.
This continues until no processes remain in the ready queue.

Each time a process is executed and it has no further pages to be executed, main memory is checked for available space. If available space is found equalant for a process in the block queue, then the next process in the blocked queue is pulled, paginated, saved in main memory and moved to the ready queue.

The available Queues include:
A. Ready Queue - Those processes not yet partially or entirely executed
B. Blocked Disk Queue - Those processed that are partially executed but require further CPU and disk memory to complete

A Memory Manager is used to manage a limited memory space and controls pagination and frame storage.

A Scheduling Manager is used to manage the available queues.

To run this application you have the following options:

1. run the main file without parameters. This will default to use 20 processes, 10 processes available to be stored in memory at a time, and a 64 byte page size
2. run the main file with parameters. Parameter input is as follows:
    1. Number of processes to create
    2. Number of processes allowed to be stored in main memory at a time
    3. The page size for a given process.

This application will print out the state of the queues throughout CPU processing, along with times taken by the CPU to process each page.



