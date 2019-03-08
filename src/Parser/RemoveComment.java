package Parser;

class RemoveComment {

    RemoveComment(){}

    String deleteComment(String myString) {
        if (!myString.contains("#")) {
             return myString;
        } else {
            return myString.substring(0, myString.indexOf("#"));
        }
    }

}
