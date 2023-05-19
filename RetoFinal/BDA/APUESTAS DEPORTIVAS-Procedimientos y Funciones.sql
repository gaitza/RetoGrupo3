use apuestas;

DELIMITER //
DROP PROCEDURE IF EXISTS ActualizarSaldos;
//CREATE PROCEDURE ActualizarSaldos(cA char(3), result char(1), cP char(3))
BEGIN
DECLARE codigoCuenta char(3);
DECLARE dinero float;
DECLARE opcion char(1);
DECLARE fin bool default 0;
   
    #Creas un cursor que te guarda la informacion que necesitas de la tabla realizar
    DECLARE c CURSOR FOR SELECT Cod_Cuenta, Dinero_Apost, Opcion_Apost FROM realizar WHERE cod_Apuesta = cA;
   
    #Creas una excepcion para que no te de error el bucle
    DECLARE continue handler for not found SET fin = 1;
   
UPDATE partido 
SET 
    resultado = result
WHERE
    cod_partido = cP;
   
    #Abres el cursor
    OPEN c;    
    
    #Coges la info del cursor
    FETCH c into codigoCuenta, dinero, opcion;
   
    #El bucle va en torno a todos los que han apostado en esa apuesta
    WHILE fin = 0 DO

	#Si han apostado a la opcion correcta se actualiza su salario con el dinero apostado * la cuota
        IF opcion = result THEN
			UPDATE usuario
            SET saldo = saldo + dinero * (SELECT cuota FROM apuesta WHERE cod_apuesta = cA)
            WHERE Cod_Cuenta = codigoCuenta;
        END IF;
       
        #Coges la info del cursor
		FETCH c into codigoCuenta, dinero, opcion;

	END WHILE;
   
    #Cierras el cursor
CLOSE c;

END //