<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:ui="http://www.sun.com/web/ui">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <ui:page binding="#{LoginStudent.page1}" id="page1">
            <ui:html binding="#{LoginStudent.html1}" id="html1">
                <ui:head binding="#{LoginStudent.head1}" id="head1">
                    <ui:link binding="#{LoginStudent.link1}" id="link1" url="/resources/stylesheet.css"/>
                </ui:head>
                <ui:body binding="#{LoginStudent.body1}" id="body1" style="-rave-layout: grid">
                    <ui:form binding="#{LoginStudent.form1}" id="form1">
                        <ui:passwordField binding="#{LoginStudent.passwordField1}" id="passwordField1" style="left: 24px; top: 96px; position: absolute" validator="#{LoginStudent.passwordField1_validate}"/>
                        <ui:textField binding="#{LoginStudent.textField1}" id="textField1" style="left: 24px; top: 48px; position: absolute"
                            validator="#{LoginStudent.textField1_validate}" valueChangeListener="#{LoginStudent.textField1_processValueChange}"/>
                        <ui:button action="#{LoginStudent.button1_action}" binding="#{LoginStudent.button1}" id="button1"
                            style="left: 95px; top: 144px; position: absolute" text="Submit"/>
                        <ui:label binding="#{LoginStudent.label1}" id="label1" style="left: 24px; top: 72px; position: absolute" text="Password:"/>
                        <ui:label binding="#{LoginStudent.label2}" id="label2" style="left: 24px; top: 24px; position: absolute" text="Student ID:"/>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
