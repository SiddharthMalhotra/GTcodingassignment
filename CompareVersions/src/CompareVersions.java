/*
 * Author: Sid Malhotra
 */

import java.util.Arrays;
import java.util.Comparator;

class VersionComparator implements Comparator<String> {
    public int compare(String v1, String v2) {
        String[] v1Parts = v1.split("\\.");
        String[] v2Parts = v2.split("\\.");

        int i = 0;
        while (i < v1Parts.length || i < v2Parts.length) {
            int v1Part = (i < v1Parts.length) ? Integer.parseInt(v1Parts[i]) : 0;
            int v2Part = (i < v2Parts.length) ? Integer.parseInt(v2Parts[i]) : 0;

            if (v1Part != v2Part) {
                return Integer.compare(v2Part, v1Part);
            }
            i++;
        }

        return 0;
    }
}


public class CompareVersions {

	public static void main(String[] args) {
        String[] versions1 = {"1.0.1", "2.4.15"};
        String[] versions2 = {"4.3.11", "4.5.6"};
        String[] versions3 = {"3.9.5", "4.3.11", "8.1.2", "4.3.6", "4.5.6"};

        System.out.println(Arrays.toString(sortVersions(versions1)));
        System.out.println(Arrays.toString(sortVersions(versions2)));
        System.out.println(Arrays.toString(sortVersions(versions3)));
    }

    public static String[] sortVersions(String[] versions) {
        Arrays.sort(versions, new VersionComparator());
        return versions;
    }

}

/*
Output: 
	[2.4.15, 1.0.1]
	[4.5.6, 4.3.11]
	[8.1.2, 4.5.6, 4.3.11, 4.3.6, 3.9.5]
*/
