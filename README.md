# Smooth Clicker
_A free open-source easy to use material-designed autoclicker for Android rooted devices._

This app can trigger software clicks thanks to system Shell commands executed as SU.
The app is open-source, easy to use and to configure and can make several clicks with delayed starts and pauses between each click.
You can also repeat clicks sequences and make infinite clicks loops.
The app possesses a dedicated Android service you can reach and trigger to make some click processes instead of using the GUI.

_Why this app? Because I wanted to build my own autoclicker to make some tricks on games or on apps (like <a href="https://play.google.com/store/apps/details?id=com.mlt.woy&hl=fr">Woy !</a>)_

**Be aware this app is still in development and your device must be rooted**

***
## Screen shots
<table>
<tr>
<td>
<img src="https://github.com/pylapp/SmoothClicker/blob/master/app/dev/misc/ui_v1.6.2/ui_snackbar_arcmenu_en.png" alt="Start or stops the process, add new points or ask for SU grant" width="200">
</td>
<td>
<img src="https://github.com/pylapp/SmoothClicker/blob/master/app/dev/misc/ui_v1.6.2/selectmultipoint_en.png" alt="Select points everywhere on the device's screen" width="200">
</td>
</tr>
<tr>
<td>
<img src="https://github.com/pylapp/SmoothClicker/blob/master/app/dev/misc/ui_v1.6.2/selectmultipoint_en_2.png" alt="Select several points" width="200">
</td>
<td>
<img src="https://github.com/pylapp/SmoothClicker/blob/master/app/dev/misc/ui_v1.6.2/notificationsongoing_en.png" alt="Notifications displayed during the process" width="200">
</td>
</tr>
</table>

***
## How to use the service ?

_You can simply use the app iteself, or use the embedded Android Service to reach :_

First, create the good intent:<br/>
`Intent intentServiceSmoothClicker = new Intent("com.pylapp.smoothclicker.clicker.ServiceClicker.START");`

Then define the configuration to set up:<br/>
`intentServiceSmoothClicker.putExtra("0x000011", true); // Start delayed ?`<br/>
`intentServiceSmoothClicker.putExtra("0x000012", 10);   // How much delay for the start ?`<br/>
`intentServiceSmoothClicker.putExtra("0x000013", 2);    // The amount of time to wait between clicks`<br/>
`intentServiceSmoothClicker.putExtra("0x000021", 5);    // The number of repeat to do`<br/>
`intentServiceSmoothClicker.putExtra("0x000022", false);// Endless repeat ?`<br/>
`intentServiceSmoothClicker.putExtra("0x000031", false);// Vibrate on start ?`<br/>
`intentServiceSmoothClicker.putExtra("0x000032", true);// Vibrate on each click ?`<br/>
`intentServiceSmoothClicker.putExtra("0x000041", true);// Make notifications ?`<br/>

Today the points to click on are in one list like:<br/>
`ArrayList<Integer> points = new ArrayList<Integer>();`<br/>
`points.add(252); // x0`<br/>
`points.add(674); // y0`<br/>
etc<br/>
`intentServiceSmoothClicker.putIntegerArrayListExtra("0x000051",points); // The list of points`<br/>

Finally, starts the service: <br/>
`startService(intentServiceSmoothClicker);`


***
## Features
* device may vibrate on start and aon each click
* device may display notifications when the process is on going, on clicks and when the countdown is decrementing
* several points can be selected
* a sequence of clicks can be repeated, endlessly if needed
* a delay can be defined before each sequence of clicks
* a pause can me made between each click
* supported languages: English, French, Klingon
