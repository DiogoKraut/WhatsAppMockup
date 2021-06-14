import java.util.ArrayList;

class Group {
    ArrayList<User> admins;
    ArrayList<User> users;
    ArrayList<Message> msgs;

    String desc;

    Group(String desc, User creator) {
        this.desc   = desc;
        this.admins = new ArrayList<User>();
        this.users  = new ArrayList<User>();
        this.msgs   = new ArrayList<Message>();

        /* User who created group is an admin */
        this.admins.add(creator);
        this.users.add(creator);
    }

    /* Spreads the message received from an user to other users in the group */
    void spreadMessage() {
        for(User u : users) {
        	// if u wasn't the sender of the message
            if( msgs.get(msgs.size()-1).sender != u) {
                u.recvMessage(msgs.get(msgs.size()-1));
            }
        }
    }

    /* Check is user 'u' is in group */
    boolean hasUser(User u) {
        for(User i : users) {
            if(i == u) 
                return true;
        }
        return false;
    }

    /* Check if user 'u' is an admin */
    boolean isAdmin(User u) {
        for(User i : admins) {
            if(i == u)
                return true;
        }
        return false;
    }
}