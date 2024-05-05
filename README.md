# hello-google-photos-java

## Getting Started

Open https://developers.google.com/oauthplayground/.
Request an access token with the scope `https://www.googleapis.com/auth/photoslibrary`.
See https://developers.google.com/photos/library/guides/authorization for details.

Run it with `OAUTH2_ACCESS_TOKEN` variable.

```sh
read -s OAUTH2_ACCESS_TOKEN
export OAUTH2_ACCESS_TOKEN
./gradle run
```
