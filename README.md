# Timer-Android-App-JAVA-XML
Create an android app in java/kotlin (kotlin preferable) with Target SDK Version of 30 and Min SDK version 16.

<ol type="a">
  <li>Create an app with three screens. (A,B,C)</li>
  <li>On launch of the app start a timer which is triggered every 5 seconds. The timer should not stop even if the app is in the background or killed.</li>
  <li>A is the launch screen.</li>
  <li>A will have a button for navigating to screen B. Screen B will have a back button on click of which user will move back to screen A.</li>
  <li>B will have a button for navigating to screen C. Screen C will have a back button on click of which user will move back to screen B.</li>
  <li>All three screens should have common UI.</li>
    <ol type="I">
      <li> A “Next” button to navigate to the next screen.</li>
      <li> Back button.</li>
      <li> A textView to show updated timer value</li>
    </ol>
  <li>There will be a ”Stop Timer” button on Screen A which will stop the timer. Timer should stop only when clicked on this button</li>
  <li>The app should have only one timer running at a time.</li>
 </ol>

# Using Thread concept - App works in background
Timer triggered after every 5 seconds either it is in background or in use</br>
Using Intent activity pass the value of Timer and show in the text view and it continues updated.</br></br>
<b>Stop timer</b> button in the A activity - stop the timer and finish the activity and when we again start the app it starts from starting means 0.
