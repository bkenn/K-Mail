package com.github.bkenn.mail

import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeBodyPart
import javax.mail.internet.MimeMessage
import javax.mail.internet.MimeMultipart

/**
 * Created: Brian
 * Date:    8/2/2017
 */
object Mail {
    fun create(session: Session, op: MimeMessage.() -> Unit) {
        try {
            val message = MimeMessage(session)
            message.op()
            Transport.send(message)
        } catch (ex: MessagingException) {
            ex.printStackTrace()
        }
    }
}

fun email(session: Session, op: MimeMessage.() -> Unit) {
    try {
        val message = MimeMessage(session)
        message.op()
        Transport.send(message)
    } catch (ex: MessagingException) {
        ex.printStackTrace()
    }
}

fun MimeMessage.from(fr: String) {
    setFrom(InternetAddress(fr))
}
fun MimeMessage.subject(s: String) {
    subject = s
}

fun MimeMessage.to(to: String) {
    addRecipients(Message.RecipientType.TO, InternetAddress.parse(to))
}
fun MimeMessage.to(list: List<String>) {
    list.forEach { to -> addRecipients(Message.RecipientType.TO, InternetAddress.parse(to)) }
}

fun MimeMessage.body(op: Multipart.() -> Unit) {
    val multipart = MimeMultipart()
    multipart.op()
    setContent(multipart)
}

fun Multipart.part(op: MimeBodyPart.() -> Unit) {
    val message = MimeBodyPart()
    message.op()
    addBodyPart(message)
}

fun Multipart.message(msg: String) {
    val message = MimeBodyPart()
    message.setText(msg)
    addBodyPart(message)
}

fun Multipart.file(dir: String, name: String) {
    val fileMessage = MimeBodyPart()
    fileMessage.dataHandler = javax.activation.DataHandler(javax.activation.FileDataSource("$dir\\$name"))
    fileMessage.fileName = name
    addBodyPart(fileMessage)

}

fun MimeBodyPart.file(dir: String, name: String) {
    dataHandler = javax.activation.DataHandler(javax.activation.FileDataSource("$dir\\$name"))
    fileName = name
}
