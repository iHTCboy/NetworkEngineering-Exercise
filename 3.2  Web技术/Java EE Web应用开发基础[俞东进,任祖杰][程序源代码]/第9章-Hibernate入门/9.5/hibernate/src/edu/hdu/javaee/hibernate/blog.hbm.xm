<?xml version="1.0"?>
<!DOCTYPE hibernate-mapping PUBLIC
        "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
        "http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd">
<hibernate-mapping>
<!--�����ࡢ��֮���ӳ��-->
<class name="edu.hdu.javaee.hibernate.Blog" table="BLOG">
<!�����������������ֶ�֮���ӳ��-->
<id name="id" column="id">
<generator class="native" />
</id>
<property name="title" type="string" column="Title"/>
<property name="content" type="string" column="CONTENT"/>
<property name="date" type="timestamp" column="TIME"/>
</class>
</hibernate-mapping>
