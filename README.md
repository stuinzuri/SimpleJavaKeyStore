SimpleJavaKeyStore
==================

Travis CI: [![Build Status](https://travis-ci.org/stuinzuri/SimpleJavaKeyStore.png?branch=master)](https://travis-ci.org/stuinzuri/SimpleJavaKeyStore)


A simple Java key store from a StackOverflow answer to [Easy way to store/restore encryption key for decrypting string in java](http://stackoverflow.com/questions/1925104/easy-way-to-store-restore-encryption-key-for-decrypting-string-in-java/7176483#7176483).  

I'm a fan of static utility functions and static imports.
```java
import static ch.geekomatic.sjks.KeyStoreUtils.generateKey;
import static ch.geekomatic.sjks.KeyStoreUtils.loadKey;
import static ch.geekomatic.sjks.KeyStoreUtils.saveKey;
```
Generating a key:

```java
SecretKey originalKey = generateKey();
```

Saving a key:

```java
File file = new File("/path/to/key.file");
saveKey(originalKey, file);
```

Loading a key:

```java
File file = new File("/path/to/key.file");
SecretKey persistedKey = loadKey(file);
```
