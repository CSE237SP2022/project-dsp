This will be a "points" tracker for the active DSP brothers — Alpha Chi chapter (WashU)

- **Key features** 
    -*brothers can view their points*
    -*admin have extra features with a "password" - password: rose*
    -*admin can add and remove brothers, change points, view a list of all brothers + points*
    -*brother information is stored in a gson file*
    
    
This second iteration was spent polishing the student class and main method abilities, adding an admin privilege, and storing student information in JSON. We created a passcode-like ability in which admin privileges can be accessed by typing in “rose” in the initial user input. Admins are granted additional capabilities of creating a brother, removing a brother and changing points. We are still working on implementing “add company” and “add event” to admin privileges. The resume properties and event properties have not been fully implemented yet.

Another part of our second iteration is incorporating JSON to store our information. In order to run our code, the user MUST have gson set up. Below we have added some basic instructions for how to set this up:

- download this JSON jar file: [https://repo1.maven.org/maven2/com/google/code/gson/gson/2.6.2/gson-2.6.2.jar](https://repo1.maven.org/maven2/com/google/code/gson/gson/2.6.2/gson-2.6.2.jar)
- follow instructions on this easy-to-follow website to incorporate the newly downloaded file in java user libraries [https://medium.com/programmers-blockchain/importing-gson-into-eclipse-ec8cf678ad52](https://medium.com/programmers-blockchain/importing-gson-into-eclipse-ec8cf678ad52)
- Once downloaded, navigate to eclipse. Right click the project folder → build path → configure build path → libraries (top tab bar) → click on the gson file you just downloaded → click the edit button → edit the path to be where the file is on your device

Gson is now ready to be used, and our main method is able to be run. We incorporated JSON in this iteration with two methods, a read JSON method and a right to JSON method. The read JSON method calls the method in main, and the righttoJSON method is called anytime you update all students, and rewrites over the old file each time.

Our code is functional with the exception of the the "Cr" and "E" commands to create a company and event, respectively. We hope to accomplish this in our next iteration.
