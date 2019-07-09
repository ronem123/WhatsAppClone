import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';

class SignUpPage extends StatefulWidget {
  var inValidEmail = false;
  var inValidPassword = false;

  @override
  _SignUpPageState createState() => _SignUpPageState();
}

class _SignUpPageState extends State<SignUpPage> {
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
    return signUpView();
  }

  Widget signUpView() {
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

    final signUpButton = Padding(
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
            proceedToSignUp(emailController.text, passwordController.text);
          },
          child: Text('Sign Up', style: TextStyle(color: Colors.white)),
        ),
      ),
    );

    final oldUser = Text("Already member?",
        style: TextStyle(
            fontWeight: FontWeight.normal,
            color: Theme.of(context).primaryColor));

    final signIn = GestureDetector(
        onTap: () {
          Navigator.pop(context);
        },
        child: Text("Login",
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
                    signUpButton,
                    SizedBox(height: 15),
                    Row(
                      children: <Widget>[oldUser, SizedBox(width: 10), signIn],
                    )
                  ],
                ),
              ),
            )));
  }

  void proceedToSignUp(String email, String password) {
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
            Map<String, String> user = {"email": email, "password": password};
            dbReference.setData(user).whenComplete(() {
              emailController.text = "";
              passwordController.text = "";
            });
            Navigator.pop(context);
          } else {
            showAlertDialog("User Already exists with $email");
          }
        });
      }
    });
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
