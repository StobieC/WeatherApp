# WeatherApp

App for showing weather forecast.

Design: 
The user can select a city that they have added from a spinner on the main screen. They can also add new cities by pressing the add city
button or by opening up the settings from the ActionBar. On the settings screen a user can add a city or delete it by tapping on the city
in the list. This data is persisted by storing it in an SQLite database. From the main screen the user can tap view forecast to open up
the forecast for the city currently selected in the spinner. Communication with the API is done through Volley.

Constraints: 
I have added a GPS service for getting Longitude and latitude of the users current location but have not fully implemented this within the 
app instead focusing on getting the core part of the test finished.

In the interest of time I have chosen to implement just the current forecast.  

Test:
I have included some simple Robotium tests
