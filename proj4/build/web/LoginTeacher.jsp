<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:ui="http://www.sun.com/web/ui">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <ui:page binding="#{LoginTeacher.page1}" id="page1">
            <ui:html binding="#{LoginTeacher.html1}" id="html1">
                <ui:head binding="#{LoginTeacher.head1}" id="head1">
                    <ui:link binding="#{LoginTeacher.link1}" id="link1" url="/resources/stylesheet.css"/>
                </ui:head>
                <ui:body binding="#{LoginTeacher.body1}" id="body1" style="-rave-layout: grid">
                    <ui:form binding="#{LoginTeacher.form1}" id="form1">
                        <ui:textField binding="#{LoginTeacher.textField1}" id="textField1" style="left: 24px; top: 48px; position: absolute"/>
                        <ui:label binding="#{LoginTeacher.label1}" id="label1" style="position: absolute; left: 24px; top: 24px" text="Teacher ID:"/>
                        <ui:label binding="#{LoginTeacher.label2}" id="label2" style="left: 24px; top: 72px; position: absolute" text="Password:"/>
                        <ui:passwordField binding="#{LoginTeacher.passwordField1}" id="passwordField1" style="position: absolute; left: 24px; top: 96px"/>
                        <ui:button action="#{LoginTeacher.button1_action}" binding="#{LoginTeacher.button1}" id="button1"
                            style="left: 95px; top: 144px; position: absolute" text="Submit"/>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
