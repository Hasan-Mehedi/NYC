# NYC
MVVM pattern is used to build the app. The reason to chose this pattern is:
1. Unit testing is much easier with MVVM pattern, because there is no dependency on the view. When testing, one only need to verify that the observable variables are set appropriately when the model changes. 
2. Code is much cleaner with one layer only dependent to the below layer. 
3. Used android architecture component ViewModel and Live data so that it can survive any configuration changes (e.g screen rotation) and the data can be provided to the view immediately (no more networking operation)
