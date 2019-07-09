import 'package:flutter/material.dart';
import '../whatsapp_home.dart';
import 'package:cloud_firestore/cloud_firestore.dart';

class LoginPage extends StatefulWidget {
  var inValidEmail = false;
  var inValidPassword = false;

  @override
  _LoginPageState createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {
  TextEditingController emailController;
  TextEditingController passwordController;

  @override
  void initState() {
    super.initState();
    emailController = TextEditingController();
    passwordController = TextEditingController();
  }

  @override
  void dispose() {
    emailController.dispose();
    passwordController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return loginView();
  }

  Widget loginView() {
    final logo = Hero(
      tag: 'hero',
      child: CircleAvatar(
        backgroundColor: Colors.transparent,
        radius: 50,
        child: Image.asset("assets/images/logo.png"),
      ),
    );

    final email = TextFormField(
      controller: emailController,
      keyboardType: TextInputType.emailAddress,
      autofocus: false,
      decoration: InputDecoration(
          prefixIcon: Icon(Icons.email, color: Theme.of(context).primaryColor),
          hintText: "Email",
          errorText: widget.inValidEmail ? "Please enter valid email" : null,
          contentPadding: EdgeInsets.fromLTRB(20, 10, 20, 10),
          border: OutlineInputBorder(borderRadius: BorderRadius.circular(20))),
    );

    final password = TextFormField(
      controller: passwordController,
      obscureText: true, //for password type
      autofocus: false,
      decoration: InputDecoration(
          prefixIcon:
              Icon(Icons.lock_outline, color: Theme.of(context).primaryColor),
          hintText: "Password",
          errorText:
              widget.inValidPassword ? "Please enter valid password" : null,
          contentPadding: EdgeInsets.fromLTRB(20, 10, 20, 10),
          border: OutlineInputBorder(borderRadius: BorderRadius.circular(20))),
    );

    final loginButton = Padding(
      padding: EdgeInsets.symmetric(vertical: 16.0),
      child: Material(
        borderRadius: BorderRadius.circular(30.0),
        shadowColor: Colors.lightBlueAccent.shade100,
        elevation: 5.0,
        color: Theme.of(context).primaryColor,
        child: MaterialButton(
          minWidth: MediaQuery.of(context).size.width, //size of screen width
          height: 42.0,
          onPressed: () {
            proceedToLogin(emailController.text, passwordController.text);
          },
          child: Text('Log In', style: TextStyle(color: Colors.white)),
        ),
      ),
    );

    final forgotPassword = Align(
      alignment: Alignment.centerRight,
      child: Text("forgot password?",
          style: TextStyle(
              fontWeight: FontWeight.bold,
              color: Theme.of(context).primaryColor)),
    );

    final newUser = Text("Do not have account?",
        style: TextStyle(
            fontWeight: FontWeight.normal,
            color: Theme.of(context).primaryColor));

    final signUp = GestureDetector(
        onTap: () {
          Navigator.pushNamed(context, '/signup');
        },
        child: Text("Create now",
            style: TextStyle(
                fontWeight: FontWeight.bold,
                color: Theme.of(context).primaryColor)));

    return Scaffold(
        body: Container(
            width: MediaQuery.of(context).size.width,
            decoration: BoxDecoration(
              image: DecorationImage(
                  image: AssetImage("assets/images/bg.png"), fit: BoxFit.cover),
            ),
            child: Center(
              child: Container(
                width: 300,
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: <Widget>[
                    logo,
                    SizedBox(height: 35),
                    email,
                    SizedBox(height: 15),
                    password,
                    SizedBox(height: 15),
                    forgotPassword,
                    SizedBox(height: 15),
                    loginButton,
                    SizedBox(height: 15),
                    Row(
                      children: <Widget>[newUser, SizedBox(width: 10), signUp],
                    )
                  ],
                ),
              ),
            )));
  }

  void proceedToLogin(String email, String password) {
    setState(() {
      if (email.isEmpty) {
        widget.inValidEmail = true;
      } else if (password.isEmpty) {
        widget.inValidEmail = false;
        widget.inValidPassword = true;
      } else {
        widget.inValidPassword = false;
        DocumentReference dbReference =
            Firestore.instance.collection("user").document(email);

        dbReference.get().then((user) {
          if (user.data == null) {
            showAlertDialog("User not found");
          } else {
            if (user.data['password'] == password) {
              launchHome();
            } else {
              showAlertDialog("Invalid username password");
            }
          }
        });
      }
    });
  }

  void launchHome() {
    Navigator.pushNamed(context, '/home');
  }

  void showAlertDialog(String message) {
    // flutter defined function
    showDialog(
      context: context,
      builder: (BuildContext context) {
        // return object of type Dialog
        return AlertDialog(
          title: new Text("System says"),
          content: new Text(message),
          actions: <Widget>[
            // usually buttons at the bottom of the dialog
            new FlatButton(
              child: new Text("Close"),
              onPressed: () {
                Navigator.of(context).pop();
              },
            ),
          ],
        );
      },
    );
  }
}
