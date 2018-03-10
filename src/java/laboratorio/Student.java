/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio;

/**
 *
 * @author Miriam
 */
public class Student {
 private String name;
 private int id;  
 private String surname;
 private int age;
 private String group;
 private String specialty;
 public Student() {
 }
 public Student(int id,String name, String surname, int age, String group, String specialty) {
 this.id = id;
 this.name = name;
 this.surname = surname;
this.age = age;
this.group=group;
this.specialty = specialty;
 }
 public int getId() {
 return id;
 }
 public String getName() {
 return name;
 }
 public String getSurname() {
 return surname;
 }
 public int getAge() {
 return age;
 }
 public String getGroup() {
 return group;
 }
 public String getSpecialty() {
 return specialty;
 }
 public void setId(int id) {
 this.id = id;
 }
 public void setName(String name) {
 this.name = name;
 }
 public void setSurname(String surname) {
 this.surname = surname;
 }
 public void setAge(int age) {
 this.age = age;
 }
 public void setGroup(String group) {
 this.group = group;
 }
 public void setSpecialty(String specialty) {
 this.specialty = specialty;
 }
 
}
