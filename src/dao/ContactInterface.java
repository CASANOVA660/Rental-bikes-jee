package dao;

import Beans.Contact;
import java.util.List;

public interface ContactInterface {
    void getContactById(int id);
    List<Contact> getAllContacts();
    void addContact(Contact contact);
    void updateContact(Contact contact);
    void deleteContact(int id);
}
