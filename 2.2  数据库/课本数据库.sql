--����ѧ����
create table Student(
  Sno char(9) primary key,
  Sname char(10)unique,	
  Ssex char(2),
  Sage smallint,
  Sdept char(20)
)

--��������
  insert into Student values('200215121','����','��',20,'CS');
  insert into student values('200215122','����','Ů',19,'CS');
  insert into student values('200215123','����','Ů',18,'MA');
  insert into student values('201215125','����','��',19,'IS');
 
--drop table Student;

--�����γ̱�
create table Course(
   Cno char(9) primary key,
   Cname char(40) unique,
   Cpno char(4),
   Ceredit smallint, 
)

--��������
  insert into Course values('1','���ݿ�','5',4)
  insert into Course values('2','��ѧ','',2)
  insert into Course values('3','��Ϣϵͳ','1',4)
  insert into Course values('4','����ϵͳ','6',3)
  insert into Course values('5','���ݽṹ','7',4)
  insert into Course values('6','���ݴ���','',2)
  insert into Course values('7','PASCAL����','6',4)

--drop table  Course;

--��������
create table SC(
   Grade smallint,
   Sno char(9) constraint fk_Sno foreign key references Student(Sno),
   Cno char(9)  foreign key references Course(Cno),
   --constraint pk_SC  primary key (Sno,Cno,Grade) --�������ֶα��һ����ͬ����
)

--��������
   insert into SC values(92,'200215121','1')
   insert into SC values(85,'200215121','2')
   insert into SC values(88,'200215121','3')
   insert into SC values(90,'200215122','2')
   insert into SC values(80,'200215122','3')
   
--drop table SC

--select * from Course,Student,SC


