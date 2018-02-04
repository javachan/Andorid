<?php



if($_SERVER["REQUEST_METHOD"]=="POST")
{

	require 'connection.php';

	update();

}




function update()

{

	global $connect;


		
	
	$degiseceksutun = $_POST["degiseceksutun"];
	
	$yazilacakmetin = $_POST["yazilacakmetin"];

		$degisecekgun = $_POST["degisecekgun"];
		$degiseceksinifno = $_POST["degiseceksinifno"];


		
		if($degiseceksutun=='1')
		{
		$query = "Update siniflargun set gun1='$yazilacakmetin' where sinifno='$degiseceksinifno' and gun='$degisecekgun' ";

		}
		if($degiseceksutun=='2')
		{
		$query = "Update siniflargun set gun2='$yazilacakmetin' where sinifno='$degiseceksinifno' and gun='$degisecekgun' ";

		}
		if($degiseceksutun=='3')
		{
		$query = "Update siniflargun set gun3='$yazilacakmetin' where sinifno='$degiseceksinifno' and gun='$degisecekgun' ";

		}
		if($degiseceksutun=='4')
		{
		$query = "Update siniflargun set gun4='$yazilacakmetin' where sinifno='$degiseceksinifno' and gun='$degisecekgun' ";

		}
		if($degiseceksutun=='5')
		{
		$query = "Update siniflargun set gun5='$yazilacakmetin' where sinifno='$degiseceksinifno' and gun='$degisecekgun' ";

		}
		if($degiseceksutun=='6')
		{
		$query = "Update siniflargun set gun6='$yazilacakmetin' where sinifno='$degiseceksinifno' and gun='$degisecekgun' ";

		}
		if($degiseceksutun=='7')
		{
		$query = "Update siniflargun set gun7='$yazilacakmetin' where sinifno='$degiseceksinifno' and gun='$degisecekgun' ";

		}
		if($degiseceksutun=='8')
		{
		$query = "Update siniflargun set gun8='$yazilacakmetin' where sinifno='$degiseceksinifno' and gun='$degisecekgun' ";

		}
		if($degiseceksutun=='9')
		{
		$query = "Update siniflargun set gun9='$yazilacakmetin' where sinifno='$degiseceksinifno' and gun='$degisecekgun' ";

		}
		if($degiseceksutun=='10')
		{
		$query = "Update siniflargun set gun10='$yazilacakmetin' where sinifno='$degiseceksinifno' and gun='$degisecekgun' ";

		}
		if($degiseceksutun=='11')
		{
		$query = "Update siniflargun set gun11='$yazilacakmetin' where sinifno='$degiseceksinifno' and gun='$degisecekgun' ";

		}
		if($degiseceksutun=='12')
		{
		$query = "Update siniflargun set gun12='$yazilacakmetin' where sinifno='$degiseceksinifno' and gun='$degisecekgun' ";

		}
		if($degiseceksutun=='13')
		{
		$query = "Update siniflargun set gun13='$yazilacakmetin' where sinifno='$degiseceksinifno' and gun='$degisecekgun' ";

		}
		if($degiseceksutun=='14')
		{
		$query = "Update siniflargun set gun14='$yazilacakmetin' where sinifno='$degiseceksinifno' and gun='$degisecekgun' ";

		}

					


	
	mysqli_query($connect, $query) or die (mysqli_error($connect));
		mysqli_close($connect);




}











?>
