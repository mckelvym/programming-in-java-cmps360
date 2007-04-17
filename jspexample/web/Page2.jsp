<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:ui="http://www.sun.com/web/ui">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <ui:page binding="#{Page2.page1}" id="page1">
            <ui:html binding="#{Page2.html1}" id="html1">
                <ui:head binding="#{Page2.head1}" id="head1">
                    <ui:link binding="#{Page2.link1}" id="link1" url="/resources/stylesheet.css"/>
                </ui:head>
                <ui:body binding="#{Page2.body1}" id="body1" style="-rave-layout: grid">
                    <ui:form binding="#{Page2.form1}" id="form1">
                        <ui:label binding="#{Page2.label1}" id="label1" style="position: absolute; left: 96px; top: 72px" text="gay crap"/>
                        <ui:label binding="#{Page2.label2}" id="label2" style="position: absolute; left: 336px; top: 120px" text="fucking retarded"/>
                        <ui:label binding="#{Page2.label3}" id="label3" style="position: absolute; left: 144px; top: 264px" text="you typed something: "/>
                        <ui:textField binding="#{Page2.textField1}" id="textField1" style="position: absolute; left: 360px; top: 288px"/>
                        <ui:button action="#{Page2.button1_action}" binding="#{Page2.button1}" id="button1" style="position: absolute; left: 312px; top: 336px" text="blah"/>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
