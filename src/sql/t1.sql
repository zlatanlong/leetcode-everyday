-- https://zhuanlan.zhihu.com/p/364006108

-- 1. 获取所有部门中员工薪水最高的相关信息，给出dept_no, emp_no以及其对应的salary，按照部门编号升序排列
select dept_no
     , emp_no
     , salary
from (select a.dept_no as dept_no
           , a.emp_no  as emp_no
           , b.salary  as salary
           , DENSE_RANK() over (partition by a.dept_no order by b.salary) as rank
      from dept_emp a
               right join
           (select emp_no
                 , from_date
                 , to_date
                 , salary

            from salaries) b
           on (a.emp_no = b.emp_no and a.from_date = b.from_date and a.to_date = b.to_date))
where rank = 1
order by dept_no desc


-- 2. 请你查找所有员工自入职以来的薪水涨幅情况，给出员工编号emp_no以及其对应的薪水涨幅growth，并按照growth进行升序
select c.emp_no            as emp_no
     , c.salary - b.salary as growth
from (select emp_no
           , min(salary) as salary
           , from_date
           , to_date
      from salaries
      group by emp_no) b
         right join
     (select emp_no
           , salary
           , from_date
           , to_date
      from salaries
      where to_date = '9999-01-01') c on (b.emp_no = c.emp_no)
order by c.salary - b.salary asc
