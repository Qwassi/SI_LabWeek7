# SI_LabWeek7
SI Lab Week 7 done by using:
- html as the form to receive user input
- servlet as the controller
- jsp as the output page
- a listener that implements ServletContextListener for database initialization
- web.xml as deployment descriptor which contains servlet, listener and context-param (to initialize param/variables) tags.
- JavaDB Derby

P/S: Forgot to close DB connection which should be in the ServletContextListener.contextDestroyed() if not mistaken.
