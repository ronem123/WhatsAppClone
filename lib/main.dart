import 'dart:async';

import 'package:flutter/material.dart';
import 'package:whats_app_clone/whatsapp_home.dart';
import 'package:camera/camera.dart';
import 'package:whats_app_clone/pages/login_screen.dart';
import 'pages/signup_screen.dart';


List<CameraDescription> cameras;

Future<Null> main() async {
  cameras = await availableCameras();
  runApp(new MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      title: "WhatsApp",
      theme: new ThemeData(
        primaryColor: new Color(0xff075E54),
        accentColor: new Color(0xff25D366),
      ),
      debugShowCheckedModeBanner: false,
      initialRoute: '/',
      routes: {
        '/home':(context)=> WhatsAppHome(),
//        '/':(context)=> LoginPage(),
        '/':(context)=> WhatsAppHome(),
        '/signup':(context)=>SignUpPage(),
      },
    );
  }
}
