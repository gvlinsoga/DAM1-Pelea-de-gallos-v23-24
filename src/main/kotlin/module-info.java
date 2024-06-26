module org.example.dam1peleadegallosv2324 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires kotlin.stdlib;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires org.mongodb.driver.kotlin.coroutine;
    requires org.mongodb.driver.reactivestreams;
    requires org.mongodb.bson;
    requires org.mongodb.driver.sync.client;
    requires io.ktor.http;
    requires java.desktop;
    requires io.ktor.client.core;
    requires io.ktor.client.cio;
    requires kotlinx.coroutines.core;
    requires kotlinx.serialization.json;
    requires io.ktor.utils;

    opens org.example.batalladegallos.gui to javafx.fxml;
    exports org.example.batalladegallos.gui;
}