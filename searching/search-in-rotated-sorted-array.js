/**
 * ? Ref - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Searching/video/MTUwNjg%3D
 *
 * @param {array} arr
 * @param {number} x
 * @returns {number}
 */

function searchInRotatedArray(arr, x) {
    let low = 0;
    let high = arr.length - 1;
    while (low <= high) {
        const mid = Math.floor((low + high) / 2);
        if (arr[mid] === x) {
            return mid;
        }
        // Check if left half of the array is sorted
        if (arr[mid] > arr[low]) {
            // check if the element is in left half
            if (arr[mid] > x && arr[low] <= x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            // right half is sorted
        } else {
            // check if right sorted subarray has the element
            if (x > arr[mid] && x <= arr[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    }
    return -1;
}

const pos = searchInRotatedArray([100, 200, 500, 1000, 2000, 10, 20], 20);
console.log(pos);
