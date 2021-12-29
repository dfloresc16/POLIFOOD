delimiter //
create view usuario_registrado as 
	select Usuarios.correo, Usuarios.celular, Usuarios.contrasenia, Usuarios.boleta,									
    Personales.nombre, Personales.paterno, Personales.materno from Usuarios inner join Personales on Usuarios.id = Personales.id_usuario_fk where (Usuarios.correo = p_correoInstitucional); 
// delimiter ;
