package seedu.addressbook.data.tag;

import java.util.ArrayList;

import seedu.addressbook.data.person.Person;

public class Tagging {

        private Person person;
        private Tag tag;
        private String tagOperation;  
        
        public static ArrayList<Tagging> TaggingList;
        
        /**
         * There are commands to add and remove tags to a person in the address book
         * This Tagging Class will represent an adding or deleting of a tag
         * 
         */
        
        public Tagging(Person person, Tag tag, String tagOperation) {
            this.person = person;
            this.tag = tag;
            this.tagOperation = tagOperation;
            TaggingList.add(this);
        }
        
        public Person getPerson() {
            return person;
        }
        
        public Tag getTag() {
            return tag;
        }
        
        public String getTagOperation() {
            return tagOperation;
        }
}
