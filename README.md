
# Remote Control Joystick Android App 
## Introduction
In this Android app, the user is allowed to control a Flight Gear simulator using a remote control for the Joystick in
the flight gear.

## MVVM Design Pattern
The app is based on the MVVM design pattern, which has 3 main components:
1. Model:  responsible to implement the algorithm that processing the data and transfer it to the FlightGear
   server
2. View: The visual graphic interface that is displayed to the users.
3. View Model: The primary responsibility of the ViewModel is to provide data to the View, so that View can put that data on the screen.
   It also allows the user to interact with data and change the data.

# How to run the app on your machine?
## Installations
In order to use our simulator app, please download the following:
1. An editor for Android - we chose the Android Studio: https://developer.android.com/studio?gclid=Cj0KCQjw_dWGBhDAARIsAMcYuJzkOersbg8QCEtM3KCm6W6v0c4f8ugCVPC-FgTCzyDJ2Xg59Mg7LEsaAu5SEALw_wcB&gclsrc=aw.ds
2. FlightGear (version 2020.3.8) - https://www.flightgear.org/
3. Clone our project

## Step by step guideline:
In order to use our simulator app, please follow the steps below:
1. In the FlightGear app:

    * go to Settings -> Additional settings.
      Then, in the text box at the bottom, paste the following text:
      
       ``--telnet=socket,in,10,127.0.0.1,6400,tcp``

![image](https://user-images.githubusercontent.com/59093573/123442241-5a099c00-d5dd-11eb-9f1e-50394665afc2.png)

* Click the ``Fly`` button at the bottom left corner.
* Click the ``Cessna`` tab and choose ```autostart```


2. Now, in your editor, run the project. Then, a small window should pop up (mocking an Android phone).
   In the app you will be required to supply two parameters:
    * Your private IP - to find your IP, open the  ``CMD`` and type ``ipconfig`` and copy the following string:

      ![image](https://user-images.githubusercontent.com/59093573/123441102-29753280-d5dc-11eb-912a-21f74a167b0d.png)


* Port - 6400
  
3. Then click ``Connect``
4. Now, using the app, you should be able to control the aircraft by using the two sliders of the throttle and
   the rudder.


![android device](https://user-images.githubusercontent.com/59093573/123536693-969bdb80-d734-11eb-8497-f23ca00074d6.jpg)


## Code Design and UML:

![uml](https://user-images.githubusercontent.com/59093573/123538678-bcc67900-d73e-11eb-86fc-ae105002fda8.jpg)

## Video Presentation And Explanation

https://youtu.be/1s4YRsgLwvc

## Video Presentation

https://youtu.be/rRVr9Poh9yU

## Video Explanation

https://youtu.be/uNmJa99AYAk

## Authors
* Or Memia
* Dvir Asaf
