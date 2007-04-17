<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:ui="http://www.sun.com/web/ui">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <ui:page binding="#{Page1.page1}" id="page1">
            <ui:html binding="#{Page1.html1}" id="html1">
                <ui:head binding="#{Page1.head1}" id="head1">
                    <ui:link binding="#{Page1.link1}" id="link1" url="/resources/stylesheet.css"/>
                </ui:head>
                <ui:body binding="#{Page1.body1}" id="body1" style="-rave-layout: grid">
                    <ui:form binding="#{Page1.form1}" id="form1">
                        <ui:label binding="#{Page1.label1}" id="label1" style="left: 168px; top: 336px; position: absolute" text="wow, this sucks a lot"/>
                        <ui:label binding="#{Page1.label2}" id="label2" style="left: 96px; top: 24px; position: absolute" text="oh so gay"/>
                        <ui:label binding="#{Page1.label3}" id="label3" style="position: absolute; left: 504px; top: 264px" text="is this annoying or what?"/>
                        <ui:textField binding="#{Page1.textField1}" id="textField1" style="left: 96px; top: 48px; position: absolute"
                            validator="#{Page1.textField1_validate}" valueChangeListener="#{Page1.textField1_processValueChange}"/>
                        <ui:button action="#{Page1.button1_action}" binding="#{Page1.button1}" id="button1" style="left: 95px; top: 72px; position: absolute" text="click me if you are gay"/>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
