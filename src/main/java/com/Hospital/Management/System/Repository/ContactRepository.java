package com.Hospital.Management.System.Repository;

import java.beans.JavaBean;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Hospital.Management.System.doclogin.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>
{

}
