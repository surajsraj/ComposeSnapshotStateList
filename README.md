# ComposeSnapshotStateList
ComposeSnapshotStateList is a tutorial Android app to showcase the usage of SnapshotStateList versus the regular State<List<out E>>. Since, List is immutable, any changes to one element in the list would update the whole list leading to unwanted recompositions.
With the help of SnapshotStateList, this can be avoided.

This app uses logs to protray the behaviour, if any list item is updated, only the particular list item would be recomposed and not every other items in the list.
