package hello;

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.OAuth2Credentials;
import com.google.photos.library.v1.PhotosLibraryClient;
import com.google.photos.library.v1.PhotosLibrarySettings;

public class Main {
    public static void main(String[] args) throws Exception {
        var settings = PhotosLibrarySettings.newBuilder().
                setCredentialsProvider(FixedCredentialsProvider.create(
                        OAuth2Credentials.create(AccessToken.newBuilder().
                                setTokenValue(System.getenv("OAUTH2_ACCESS_TOKEN")).
                                build())
                )).build();

        try (PhotosLibraryClient client = PhotosLibraryClient.initialize(settings)) {
            var listAlbums = client.listAlbums();
            for (var album : listAlbums.iterateAll()) {
                System.out.printf("%s %s (%d)", album.getId(), album.getTitle(), album.getMediaItemsCount());
                System.out.println();
            }
        }
    }
}
