package com.demo.util;

public class verifyEmails {
	
	/*public void verifyEmails(){
        final String IMAP_HOST = "imap.gmail.com";
        final String IMAP_PROTOCOL = "imap";

        String EMAIL_ADDRESS = "*****@gmail.com";
        final String PASSWORD = "**************";

        IMAPFolder folder = null;
        Store store = null;
        try {
            //1) get the session object
            Properties properties = new Properties();
            properties.setProperty("mail.imap.ssl.enable", "true");
            //properties.put("mail.pop3.host", pop3Host);
            Session emailSession = Session.getDefaultInstance(properties);
            // set any other needed mail.imap.* properties here
            Session session = Session.getInstance(properties);
            store = session.getStore(IMAP_PROTOCOL);
            store.connect(IMAP_HOST, EMAIL_ADDRESS, PASSWORD);
            folder = (IMAPFolder) store.getFolder("INBOX");
            folder.open(Folder.READ_WRITE);
            Message[] messages = folder.getMessages();
            SearchTerm searchTerm = new AndTerm(new SubjectTerm("Critical security alert"), new BodyTerm("turned on"));
            messages = folder.search(searchTerm);
            System.out.println("No of Messages : " + folder.getMessageCount());
            System.out.println("No of Unread Messages : " + folder.getUnreadMessageCount());
            System.out.println(messages.length);
            for (int i=0; i < messages.length;i++)
            {

                System.out.println(i);
                Message msg =  messages[i];

                String  subject = msg.getSubject();
                if (subject != null && !subject.isEmpty()) {
                    if (subject.toLowerCase().contains("critical security alert")) {
                        System.out.println("*****************************************************************************");
                        System.out.println("MESSAGE " + (i + 1) + ":");
                        System.out.println("Subject: " + subject);
                        System.out.println("From: " + msg.getFrom()[0]);
                        System.out.println("To: " + msg.getAllRecipients()[0]);
                        System.out.println("Date: " + msg.getReceivedDate());
                        System.out.println("Size: " + msg.getSize());
                        System.out.println(msg.getFlags());

                        System.out.println("Body: \n" + msg.getContent());
                        String result =null;
                        if (msg.isMimeType("text/plain")) {
                            result = msg.getContent().toString();
                        } else if (msg.isMimeType("multipart/*")) {
                            MimeMultipart mimeMultipart = (MimeMultipart) msg.getContent();
                            result = "This is a Multimedia Email";
                        }
                        System.out.println(msg.getContentType());
                        System.out.println("Content of Email is -->" +result);
                    }
                }

            }
        }
        finally
        {
            if (folder != null && folder.isOpen()) { folder.close(true); }
            if (store != null) { store.close(); }

        }
    } */

}
