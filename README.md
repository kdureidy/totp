# TOTP

Sample time-based one-time password application implemented for Google Authenticator mobile app

This is a commandline application that will generate a QR image, and require an input to enter the generated code and verify it.

# Prerequisites:
1. Java 1.8
2. Maven 3.x
3. Google Authenticator App, you can install it from Apple AppStore or Google Play

# How to run?
mvn exec:java

# How to package
mvn clean package

# How to use?
1. Run the application
~~~
mvn exec:java
~~~

2. Application will generate a URL for a QR image

3. Scan the image using the Google Authenticator mobile app

4. Enter the generated code in the command line and press enter, if your input is correct, output will be `yes`, if not, output will be `no`.
