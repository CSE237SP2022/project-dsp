This will be a "points" tracker for the active DSP brothers — Alpha Chi chapter (WashU)

- **Key features** 
    -*brothers can view their points*
    -*admin have extra features with a "password" - password: rose*
    -*admin can add and remove brothers, change points, view a list of all brothers + points*
    -*brother information is stored in a gson file*
    
 All of these user features can get bogged down in the code, so look for comments in the Menu (previously named Run) file that break up methods into categories. 
 
This third iteration was spent finishing up the final pieces of our DSP tracker. We added the event, company and resume components to the tracker. For events, we had characteristics such as name, points, date, and required event boolean which would contribute to each brothers points depending on attendance. In order to store this data, we implemented JSON once again as we did previously for Student. 

We also finished up the Resume class which includes information on companies and work experiences for each brother, also using JSON. Lastly, we implemented commands in the main method for all these new additions. Previous peer feedback had mentioned glitchy main menu print statements, so we made sure to also clean up bugs within our Menu (previously Run) class, including duplicate print statements and redundant code.  

– – – – –

PLEASE READ!!!! An important part of our project is incorporating JSON to store our information. We did this to make the project useful. Before the JSON file, all information was lost after quitting out of the program. Now, it is stored in a file that can be saved and exported. In order to run our code, the user MUST have gson set up. Below we have added some basic instructions for how to set this up:

    –download this JSON jar file: https://repo1.maven.org/maven2/com/google/code/gson/gson/2.6.2/gson-2.6.2.jar

    –follow instructions on this easy-to-follow website to incorporate the newly downloaded file in java user libraries https://medium.com/programmers-blockchain/importing-gson-into-eclipse-ec8cf678ad52

    –Once downloaded, navigate to eclipse. Right click the project folder → build path → configure build path → libraries (top tab bar) → click on the gson file you just downloaded → click the edit button → edit the path to be where the file is on your device

**Gson is now ready to be used, and our main method is able to be run. View the script file to find the commands to insert into the terminal.** We incorporated JSON with two methods, a read JSON method and a right to JSON method.The read JSON method calls the method in main, and the righttoJSON method is called anytime you update all students, and rewrites over the old file each time.

Our code is functional for all commands. The command execution is explained in the user output. **Remember, to gain access to exec commands, type “rose.”**

