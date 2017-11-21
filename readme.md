# XYZ Web Application 2017


### TO DO List
- [ ] Produce an "Interaction Diagram" _(See chapter 3 of book)_
- [ ] Add detailed comment to code.
- [x] Add a 'Back button' to the theme we are using for the html/css.
- [ ] Do something with the FAQ's link on the theme. Remove or add content depending on if we have time.
- [ ] Consider changing errorPage.jsp to html - no dynamic content, does it need to be a .jsp?
- [ ] Consider separating jsp files into two folders, Member functions and Admin functions?
- [ ] Add more things to do here...


### Change Log

15/11/17 - _James_
* Updated the readme and converted to Markdown. Also modified **LoginServlet.java** to direct users to different pages, depending on whether they are an admin or customer/regular user.
* Started working on the **adminPage.jsp**
* Updated **errorPage.jsp** in line with the 'theme' we've adopted.
* Changed background image on **login.jsp** for higher resolution image (image labelled for non-commercial reuse)
* Minor updates to **memberPage.jsp**, in line with style changes.

17/11/17 - _James_
* Added back button to all of the admin pages. (Modified the switch statement in the `AdminDashbordServlet.java`)
* Modified buttons on Login Page.

21/11/17 - _James_
* Modified the List all Members and list all claims functions in the admin dashboard. Results are now displayed in a table which can be scrolled up and down.
* Implemented the list all provisional applications function. Results also viewable in a table.


* Note - registering the same member again (duplicate details) just resets the password. It doesn't create a duplicate record in the DB.

Admin Dashboard to-do List.
  - [x] List All Members
  - [ ] List All outstanding balances
  - [x] List All Claims
  - [x] List All Provisional Applications
  - [ ] Process A Claim
  - [ ] Process Membership Applications
  - [ ] Suspend or Resume Membership
  - [ ] Report Annual Turnover
