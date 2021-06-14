import java.util.ArrayList;


class User {
    String name;
    String number;
    String status;
    String photo;

    User(String name) {
        this.name = name;
    }

    /* Sends a text message 'msg' to the group 'g' */
    void sendText(Group g, String msg) {
        if(g.hasUser(this)) { // If user is in the group
            Message _msg = new Message();
            _msg.sender = this;
            _msg.text = msg;
            g.msgs.add(_msg);
            g.spreadMessage();
            return;
        }
        System.out.println("User "+this.name+" not in group "+g.desc);
    }

    /* Deletes the last message sent by 'this' user */
    void cancelSend(Group g) {
        for(int i = g.msgs.size()-1; i >= 0; i--) {// Backwards search through messages 
            if(g.msgs.get(i).sender == this) {// Check if 'this' user sent the message
                g.msgs.remove(i);
                return;
            }
        }
    }

    /* Admins may add users to group if they aren't members already*/
    void addUser(Group group, User user_add) {
        if(group.isAdmin(this))
            if(!group.hasUser(user_add)) {
                group.users.add(user_add);
                return;
            }
    }

    /* Receives a message from the group */
    void recvMessage(Message msg) {
       System.out.println(this.name+": "+msg.text);
    }

    /* User may create a group */
    Group createGroup(String desc) {
        Group group = new Group(desc, this);
        return group;
    }

}