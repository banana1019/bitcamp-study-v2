package com.eomcs.mylist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.dao.ContactDao;
import com.eomcs.mylist.domain.Contact;

@RestController 
public class ContactController {

  @Autowired
  ContactDao contactDao;

  @RequestMapping("/contact/list")
  public Object list() {
    return contactDao.findAll(); 
  }

  @RequestMapping("/contact/add")
  public Object add(Contact contact) throws Exception {
    contactDao.insert(contact);
    return contactDao.countAll();
  }

  @RequestMapping("/contact/get")
  public Object get(String email) throws Exception {
    int index = contactDao.indexOf(email);
    if (index == -1) {
      return "";
    }
    return contactDao.findByNo(index);
  }

  @RequestMapping("/contact/update")
  public Object update(Contact contact) throws Exception {
    int index = contactDao.indexOf(contact.getEmail());
    if (index == -1) {
      return 0;
    }

    return contactDao.update(index, contact);
  }

  /*
  @RequestMapping("/contact/delete")
  public Object delete(String email) {
    Contact contact = contactDao.indexOf(email);
    if (contact == null) {
      return 0;
    }

    contactDao.delete(index);
    return 1;
  }
   */

  @RequestMapping("/contact/delete")
  public Object delete(String email) throws Exception {
    int index = contactDao.indexOf(email);
    if (index == -1) {
      return 0;
    }

    return contactDao.delete(index);
  }

}