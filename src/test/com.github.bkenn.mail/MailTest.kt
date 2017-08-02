package com.github.bkenn.mail

/**
 * Created: Brian
 * Date:    8/2/2017
 */
class MailTest {
}

/*
fun main(args: Array<String>) {
    val service = EmailService()

    val dir = "C:\\Pricing\\Customers\\Walker_Tommy"

    val files = listOf (Pair(dir, "Walker_Tommy_Master.docx"))

    val email = Email("from@gmail.com",
            listOf("toOne@gmail.com","toTwo@gmail.com"),
            "password-here",
            "Another Test..!!!!.",
            "TEST file message",
            files)

    service.send(email)
}

        val props = Properties()
        props.put("mail.smtp.auth", "true")
        props.put("mail.smtp.starttls.enable", "true")
        props.put("mail.smtp.host", "smtp.gmail.com")
        props.put("mail.smtp.port", "587")

        val session = Session.getInstance(props, object : javax.mail.Authenticator() {
            override fun getPasswordAuthentication(): PasswordAuthentication {
                return PasswordAuthentication(email.from, email.password)
            }
        })

       try {
           val message = MimeMessage(session)
           message.setFrom(InternetAddress(email.from))
           email.tos.forEach { to -> message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to)) }
           message.subject = email.subject

           val multipart = MimeMultipart()

           val messageBodypart1 = MimeBodyPart()
           messageBodypart1.setText(email.message)


           val messageBodypart2 = MimeBodyPart()
           val name = "Walker_Tommy_CABINETS_.docx"
           val filename = "C:\\GTPricing\\Customers\\$name"
           val source = FileDataSource(filename)
           messageBodypart2.dataHandler = DataHandler(source)
           messageBodypart2.fileName = name

           email.files?.forEach {
               fileAttachment {
                   multipart.addBodyPart(this)
               }
           }

           multipart.addBodyPart(messageBodypart1)
           multipart.addBodyPart(messageBodypart2)

           message.setContent(multipart)
           Transport.send(message)
       } catch(ex: MessagingException) {
           ex.printStackTrace()
       }

        println("done")
    }
 */