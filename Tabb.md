# Introduction #

Android 3.0, or Honeycomb, came with some fundamental user interface changes, most notably in the form of the Fragment API. When you were reading the last tutorial on how to use fragments, you were probably thinking, “Wow, this is great, but I can’t use any of this because I need to target more than just the Motorola Xoom, the only Android 3.0 device currently on the market.” Luckily for all of us developers, Google has released a library called the Android Compatibility package. This package provides support for the Fragment API as well as other key new features to devices as far back as Android 1.6. As of this writing, that covers 97% of all Android devices actively accessing the Android Market. Learn how to use it in this quick tip.

# Details #

A Fragment represents a behavior or a portion of user interface in an Activity. You can combine multiple fragments in a single activity to build a multi-pane UI and reuse a fragment in multiple activities. You can think of a fragment as a modular section of an activity, which has its own lifecycle, receives its own input events, and which you can add or remove while the activity is running (sort of like a "sub activity" that you can reuse in different activities).

A fragment must always be embedded in an activity and the fragment's lifecycle is directly affected by the host activity's lifecycle. For example, when the activity is paused, so are all fragments in it, and when the activity is destroyed, so are all fragments. However, while an activity is running (it is in the resumed lifecycle state), you can manipulate each fragment independently, such as add or remove them. When you perform such a fragment transaction, you can also add it to a back stack that's managed by the activity—each back stack entry in the activity is a record of the fragment transaction that occurred. The back stack allows the user to reverse a fragment transaction (navigate backwards), by pressing the Back button.

When you add a fragment as a part of your activity layout, it lives in a ViewGroup inside the activity's view hierarchy and the fragment defines its own view layout. You can insert a fragment into your activity layout by declaring the fragment in the activity's layout file, as a 

&lt;fragment&gt;

 element, or from your application code by adding it to an existing ViewGroup. However, a fragment is not required to be a part of the activity layout; you may also use a fragment without its own UI as an invisible worker for the activity.

This document describes how to build your application to use fragments, including how fragments can maintain their state when added to the activity's back stack, share events with the activity and other fragments in the activity, contribute to the activity's action bar, and more.

# Links #

  * http://www.androidhive.info/2011/08/android-tab-layout-tutorial/
  * http://www.android-dev.fr/web/blog/voir/129?titre=Tab-Android-premi%C3%A8re-version-Partie-1-XML&PHPSESSID=5kcdkd8fp5tdulltc2793kv0c3
  * http://www.android-dev.fr/web/blog/voir/130?titre=Tab-Android-premi%C3%A8re-version-Partie-2-JAVA&PHPSESSID=5kcdkd8fp5tdulltc2793kv0c3
  * http://mobile.tutsplus.com/tutorials/android/android-sdk_fragments/
  * http://www.lucazanini.eu/2012/android/tab-layout-in-android-with-actionbar-and-fragment/?lang=en
  * https://github.com/inazaruk/map-fragment
  * http://stackoverflow.com/questions/12870962/passing-data-on-callback-onlistitemclick-to-a-fragment